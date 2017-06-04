'use strict';
module.exports = {
    obUserText: function () {
        return browser.driver.findElement(by.id('email'));

    },

    obPwdText: function () {
        return browser.driver.findElement(by.id('password'));

    },

    obEntButton: function () {
        return browser.driver.findElement(by.xpath('//*[@id="form_login"]/button'));

    },

    obUserError: function () {
        return browser.driver.findElement(by.id('email-error'));
    }
};