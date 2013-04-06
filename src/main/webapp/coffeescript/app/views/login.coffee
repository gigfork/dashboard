define ["jquery", "underscore", "backbone", "handlebars", "text!./../templates/login.hbs"], ($, _, Backbone, Handlebars, loginTemplate) ->
  'use strict'
  
  class LoginView extends Backbone.View
    
    el: "#container"

    template: Handlebars.compile(loginTemplate)

    initialize: ->
      @render()

    render: ->
      $(@el).append(@template)
