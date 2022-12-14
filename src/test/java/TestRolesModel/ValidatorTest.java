package TestRolesModel;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.LogType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import pageObject.otherPage.MainPage;
import pageObject.otherPage.WorkingPanelPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@Story("Проверка ролевой модели валидатора")
public class ValidatorTest {

    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 30000;
        Configuration.headless = true;
    }

    @Order(1)
    @Test
    @DisplayName("Доступ к реестру \"Перечень заявок\"")
    public void testAccessToListOfApplicationValidator() {
        new MainPage()
                .entranceToMainPage()
                .entranceButtonClick()
                .enterAdminName()
                .enterAdminPassword()
                .clickEntranceButton()
                .moveCursorToAvatar()
                .clickToWorkingPanelInUsersMenu()
                .entranceToRegistryIdentity()
                .openSystemRolesFilter()
                .selectInSystemRolesFilterUsers()
                .editSystemRoleOfFirstUserInList()
                .enterNewSystemRoleInModalWindow("Валидатор")
                .closeModalWindowOfChangeSystemRole()
                .clickButtonManagementFirstUser()
                .clickButtonAuthUser()
                .enterAdminPasswordIdentity()
                .confirmIdentity()
                .moveCursorToAvatar()
                .clickToWorkingPanelInUsersMenu()
                .entranceToRegistryListOfApplication()
                .checkNameOfRegistry();
    }

    @Order(2)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Эксперты\"")
    public void testAccessDeniedToExpertsValidator() {
        new WorkingPanelPage()
                .followTheLinkExperts()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(3)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Экспертиза\"")
    public void testAccessDeniedToExpertiseValidator() {
        new WorkingPanelPage()
                .followTheLinkExpertise()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(4)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Договоры и акты с экспертами\"")
    public void testAccessDeniedToAgreementExpertValidator() {
        new WorkingPanelPage()
                .followTheLinkAgreementExpert()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(5)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Расмотрение итогов\"")
    public void testAccessDeniedToOESAdminValidator() {
        new WorkingPanelPage()
                .followTheLinkOESAdmin()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(6)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Экспертный совет\"")
    public void testAccessDeniedToOESValidator() {
        new WorkingPanelPage()
                .followTheLinkOES()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(7)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Координационный комитет\"")
    public void testAccessDeniedToCoordinatingCommitteeValidator() {
        new WorkingPanelPage()
                .followTheLinkCoordinatingCommittee()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(8)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Договоры\"")
    public void testAccessDeniedToAgreementValidator() {
        new WorkingPanelPage()
                .followTheLinkAgreement()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(9)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Отчетность по этапам\"")
    public void testAccessDeniedToReportValidator() {
        new WorkingPanelPage()
                .followTheLinkReport()
                .checkInaccessibilityRegistryForThisRole();
    }

    @AfterEach
    void getLogs() {
        LogEntries browserLogs = WebDriverRunner.getWebDriver().manage().logs().get(String.valueOf(LogType.BROWSER));

        for (LogEntry log: browserLogs) {
            Allure.addAttachment("Сообщения в консоли браузера", log.getMessage());
        }
    }

    @AfterAll
    public static void quitBrowser() {
        Selenide.closeWebDriver();
    }



}
