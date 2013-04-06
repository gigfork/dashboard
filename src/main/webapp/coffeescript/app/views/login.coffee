define ["jquery", "underscore", "backbone", "handlebars", "text!./../templates/login.hbs"], ($, _, Backbone, Handlebars, loginTemplate) ->
  'use strict'
  
  class LoginView extends Backbone.View
    
    el: "#container"

    #events:
      #"click #some-link":  "doSomething"

    template: Handlebars.compile(loginTemplate)

    initialize: ->
      @render()

    render: ->
      $(@el).html(@template)
