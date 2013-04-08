// Generated by CoffeeScript 1.6.2
(function() {
  require.config({
    shim: {
      underscore: {
        exports: "_"
      },
      backbone: {
        deps: ["underscore", "jquery"],
        exports: "Backbone"
      },
      handlebars: {
        exports: "Handlebars"
      },
      chartsjs: {
        attach: "chartsjs"
      }
    },
    paths: {
      underscore: "lib/lodash/lodash.min",
      backbone: "lib/backbone/backbone",
      text: "lib/require/text",
      handlebars: "lib/handlebars/handlebars",
      ajaxForm: "lib/form/jquery.form",
      chartsjs: "lib/chart/Chart"
    }
  });

  require(["jquery", "./app/backboneapp"], function($, BackboneApp) {
    return $(function() {
      var app;

      return app = new BackboneApp();
    });
  });

}).call(this);
