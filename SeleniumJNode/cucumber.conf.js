exports.config = {

    seleniumAddress: 'http://localhost:4444/wd/hub',

    capabilities: {
        browserName:'chrome'
    },

    framework: 'custom',  // set to "custom" instead of cucumber.

    frameworkPath: require.resolve('protractor-cucumber-framework'),  // path relative to the current config file

    specs: [
        'features/*.feature'     // Specs here are the cucumber feature files
    ],

    // cucumber command line options
    cucumberOpts: {
        require: 'C:/Users/HappyDesktop/Documents/portafolio/SeleniumJNode/features/step_definitions/*.*',  // require step definition files before executing features
        tags: [],                      // <string[]> (expression) only execute the features or scenarios with tags matching the expression
        strict: true,                  // <boolean> fail if there are any undefined or pending steps
        format: ["pretty"],            // <string[]> (type[:path]) specify the output format, optionally supply PATH to redirect formatter output (repeatable)
        dryRun: false,                 // <boolean> invoke formatters without executing steps
        compiler: []                   // <string[]> ("extension:module") require files with the given EXTENSION after requiring MODULE (repeatable)
    },

    onPrepare: function () {
        browser.manage().window().maximize(); // maximize the browser before executing the feature files
    }
};