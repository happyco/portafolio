'use strict';
var loginPage = require('../objectpage/loginPage.js');
module.exports = {
    go: function(site) {
        browser.waitForAngularEnabled(false);
        browser.driver.ignoreSynchronization = true;
        browser.driver.get(site);
        //browser.pause()
    },

    setUser: function(user) {
        loginPage.obUserText().sendKeys(user);
    },

    setPwd: function(password) {
        loginPage.obPwdText().sendKeys(password);
    },

    clickbtn: function() {
        loginPage.obEntButton().click();
    },

    emsj: function() {
        browser.driver.wait(function() {
        return loginPage.obUserError()
        }, 100);
    }


};

