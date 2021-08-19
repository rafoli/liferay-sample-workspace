beforeEach(() => {
    cy.visit('http://localhost:8080');
    cy.get('#sign-in').click();
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_login').type(Cypress.env('USER'));
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_password').type(Cypress.env('PASSWORD'));
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_loginForm').submit();
})

describe('crud sample', () => {

    it('should retrieve samples from server', () => {
        cy.get('#ng-table-samples').should('be.not.empty');
    });

    it('should create a sample', () => {
        cy.get('#ng-btn-add').click();
        cy.get('#ng-input-name').type('Sample test');
        cy.get('#ng-btn-save').click();
        cy.get('#ng-table-samples').contains('Sample test');
    });

    it('should remove all samples', () => {
        cy.get('#ng-btn-remove').click();
        cy.get('#ng-btn-remove').click();
        cy.get('#ng-table-samples').should('be.empty');
    });
});
