package com.skryl.edu;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Skryl D.V. on 2024-07-26
 */
@Testcontainers
public class ToDoMvcTests {
    @Container
    private static final GenericContainer<?> customContainer =
            new GenericContainer<>("asangin/sut-react-todo-app:latest")
                    .withExposedPorts(7002);
    static Playwright playwright;
    static Browser browser;
    private static String host;
    private static Integer port;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false)
                                .setSlowMo(150)
                );
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeAll
    static void setupContainer() {
        host = customContainer.getHost();
        port = customContainer.getMappedPort(7002);
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    @DisplayName("Verify that todo item can be created")
    void verifyThatTodoIsCreated() {
        var baseUrl = host + ":" + port;
        page.navigate(baseUrl);
        var expectedTodoMessage = "Hello World";
        var todoInput = "[id=\"todo-input\"]";
        page.fill(todoInput, expectedTodoMessage);
        page.keyboard().press("Enter");
        assertThat(page.locator("[data-testid=\"todo-item-label\"]").innerText())
                .isEqualTo(expectedTodoMessage);

    }

    @Test
    @DisplayName("Verify that todo item can be created")
    void verifyTodoListCreated() {
        var baseUrl = host + ":" + port;
        page.navigate(baseUrl);
        var todoInput = "[id=\"todo-input\"]";
        page.waitForSelector(todoInput, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        page.fill(todoInput, "todo1");
        page.keyboard().press("Enter");
        page.fill(todoInput, "todo2");
        page.keyboard().press("Enter");
        page.fill(todoInput, "todo3");
        page.keyboard().press("Enter");
        assertThat(page.locator("[data-testid=\"todo-item-label\"]").allInnerTexts())
                .hasSize(3);

    }
}
