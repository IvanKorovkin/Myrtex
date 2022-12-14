package TestRolesModel;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pageObject.otherPage.MainPage;
import pageObject.otherPage.WorkingPanelPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@Story("Проверка Ролевой модели Финансового сотрудника")
public class FinancialEmployeeTest {

    @BeforeAll
    static void setUp() {
        Configuration.timeout = 30000;
        Configuration.headless = true;
    }

    @Order(1)
    @Test
    @DisplayName("Доступ к реестру \"Договоры\"")
    public void testAccessToAgreementFinancialEmployee() {
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
                .enterNewSystemRoleInModalWindow("Фин. Сотрудник")
                .closeModalWindowOfChangeSystemRole()
                .clickButtonManagementFirstUser()
                .clickButtonAuthUser()
                .enterAdminPasswordIdentity()
                .confirmIdentity()
                .moveCursorToAvatar()
                .clickToWorkingPanelInUsersMenu()
                .entranceToRegistryAgreement()
                .checkNameOfRegistry();
    }

    @Order(2)
    @Test
    @DisplayName("Доступ к реестру \"Отчетность по этапам\"")
    public void testAccessToReportFinancialEmployee() {
        new MainPage()
                .moveCursorToAvatar()
                .clickToWorkingPanelInUsersMenu()
                .entranceToRegistryReport()
                .checkNameOfRegistry();
    }

    @Order(3)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Перечень заявок\"")
    public void testAccessDeniedToListOfApplicationFinancialEmployee() {
        new WorkingPanelPage()
                .followTheLinkListOfApplication()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(4)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Эксперты\"")
    public void testAccessDeniedToExpertsFinancialEmployee() {
        new WorkingPanelPage()
                .followTheLinkExperts()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(5)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Экспертиза\"")
    public void testAccessDeniedToExpertiseFinancialEmployee() {
        new WorkingPanelPage()
                .followTheLinkExpertise()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(6)
    @Test
    @DisplayName("Отсутсвие доступа к реестру \"Договоры и акты с экспертами (новые)\"")
    public void testAccessDeniedToAgreementExpertFinancialEmployee() {
        new WorkingPanelPage()
                .followTheLinkAgreementExpert()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(7)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Расмотрение итогов\"")
    public void testAccessDeniedToOESAdminFinancialEmployee() {
        new WorkingPanelPage()
                .followTheLinkOESAdmin()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(8)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Экспертный совет\"")
    public void testAccessDeniedToOESFinancialEmployee() {
        new WorkingPanelPage()
                .followTheLinkOES()
                .checkInaccessibilityRegistryForThisRole();
    }

    @Order(9)
    @Test
    @DisplayName("Отсутствие доступа к реестру \"Координационный комитет\"")
    public void testAccessDeniedToCoordinatingCommitteeFinancialEmployee() {
        new WorkingPanelPage()
                .followTheLinkCoordinatingCommittee()
                .checkInaccessibilityRegistryForThisRole();
    }
}
