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

    foundation:
      exports: "Foundation"

    foundation_alerts:
      deps: ["jquery", "foundation"]

    foundation_topbar:
      deps: ["jquery", "foundation"]

  paths:
    #use:        "lib/use/use.min"
    underscore: "lib/lodash/lodash.min"
    backbone:   "lib/backbone/backbone"
    text:       "lib/require/text"
    handlebars: "lib/handlebars/handlebars"
    ajaxForm:   "lib/form/jquery.form"
    chartsjs:   "lib/chart/Chart"
    foundation: "lib/foundation/foundation"
    foundation_alerts: "lib/foundation/foundation.alerts"
    foundation_topbar: "lib/foundation/foundation.topbar"

require ["jquery", "./app/backboneapp", "foundation", "foundation_alerts", "foundation_topbar"], ($, BackboneApp) ->
  $ ->
    app = new BackboneApp()
