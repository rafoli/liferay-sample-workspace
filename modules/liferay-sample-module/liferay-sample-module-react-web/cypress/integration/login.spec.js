describe('do login', () => {
    it('should do login', () => {
        cy.visit('http://localhost:8080');
        cy.get('#sign-in').click();
        cy.get('#_com_liferay_login_web_portlet_LoginPortlet_login').type('elmano.neto');
        cy.get('#_com_liferay_login_web_portlet_LoginPortlet_password').type('qwe123');
        cy.get('#_com_liferay_login_web_portlet_LoginPortlet_loginForm').submit();
    });
});
