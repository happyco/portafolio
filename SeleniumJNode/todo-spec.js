var loginPage = require('./features/source/actionpage/loginPage');

describe('comprar', function() {
    it('click comprar', function() {
        loginPage.go('https://subastas.carmatch.mx/login');
    });
});