beforeEach(() => {
    cy.visit('http://localhost:8080');
    cy.get('#_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_qfkd____').click();
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_login').type(Cypress.env('USER'));
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_password').type(Cypress.env('PASSWORD'));
    cy.get('#_com_liferay_login_web_portlet_LoginPortlet_loginForm').submit();
})

describe('crud sample', () => {    
    it('should create a sample', () => {
        cy.get('#input-sample-name').type('Sample test');
        cy.get('#btn-add-sample').click();
        cy.get('td').contains('Sample test');
    });

    it('should edit a sample', () => {
        cy.get('#btn-sample-edit-0').click();
        cy.get('#input-sample-edit-0').clear().type('Sample test edited');
        cy.get('#btn-sample-edit-0').click();
        cy.get('td').contains('Sample test edited');
    });

    it('should remove all samples', () => {
        cy.get('.btn-danger').click({ multiple: true })
        cy.get('#react-portlet-table').should('be.empty');
        
    });
});
