beforeEach(() => {
    cy.visit('http://localhost:8080');
    cy.get('#sign-in').click();
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_login').type(Cypress.env('USER'));
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_password').type(Cypress.env('PASSWORD'));
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_loginForm').submit();
})

describe('crud sample', () => {    
    it('should create a sample', () => {
        cy.get('#input-sample-name').type('Sample test');
        cy.get('#btn-add-sample').click();
        cy.get('li').contains('Sample test');
    });

    it('should edit a sample', () => {
        cy.get('#btn-sample-edit-0').click();
        cy.get('#input-sample-edit-0').clear().type('Sample test edited');
        cy.get('#btn-sample-edit-0').click();
        cy.get('li').contains('Sample test edited');
    });

    it('should remove all samples', () => {
        cy.get('#remove-1').click();
        cy.get('#remove-0').click();
        cy.get('ul').should('be.empty');
    });
});
