require.config
  
  shim:
    underscore:
      exports: "_"

    backbone:
      deps: ["underscore", "jquery"]
      exports: "Backbone"

    handlebars:
      exports: "Handlebars"

    chartsjs:
      attach: "chartsjs"

  paths:
    #use:        "lib/use/use.min"
    underscore: "lib/lodash/lodash.min"
    backbone:   "lib/backbone/backbone"
    text:       "lib/require/text"
    handlebars: "lib/handlebars/handlebars"
    ajaxForm:   "lib/form/jquery.form"
    chartsjs:   "lib/chart/Chart"

require ["jquery", "./app/backboneapp"], ($, BackboneApp) ->
  $ ->
    app = new BackboneApp()
