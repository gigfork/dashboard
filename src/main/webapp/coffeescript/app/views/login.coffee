define ["jquery", "underscore", "backbone", "handlebars", "text!./../templates/login.hbs", "text!./../templates/message.hbs"], ($, _, Backbone, Handlebars, loginTemplate, messageTemplate) ->
  'use strict'
  
  class LoginView extends Backbone.View
    
    el: "#container"

    template: Handlebars.compile(loginTemplate)

    initialize: ->
      @render()

    render: ->
      Handlebars.registerPartial("message", messageTemplate)
      $(@el).html(@template)
