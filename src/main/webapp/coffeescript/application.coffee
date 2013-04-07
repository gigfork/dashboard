require.config
  
  shim:
    underscore:
      exports: "_"

    backbone:
      deps: ["underscore", "jquery"]
      exports: "Backbone"

    handlebars:
      exports: "Handlebars"

  paths:
    underscore: "lib/lodash/lodash.min"
    backbone:   "lib/backbone/backbone"
    text:       "lib/require/text"
    handlebars: "lib/handlebars/handlebars"
    ajaxForm:       "lib/form/jquery.form"

require ["jquery", "./app/backboneapp"], ($, BackboneApp) ->
  $ ->
    app = new BackboneApp()
