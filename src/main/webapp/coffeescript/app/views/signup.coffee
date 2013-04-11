define ["jquery", "underscore", "backbone", "handlebars", "text!./../templates/signup.hbs", "text!./../templates/message.hbs"], ($, _, Backbone, Handlebars, signupTemplate, messageTemplate) ->
  'use strict'
  
  class SignupView extends Backbone.View
    
    el: "#container"

    events:
      "submit #signup-form":  "handleSubmit"
      "click .close":  "closeAlert"

    template: Handlebars.compile(signupTemplate)

    initialize: ->
      Handlebars.registerPartial("message", messageTemplate)
      @render()

    render: ->
      $(@el).html(@template)

    handleSubmit: (e) ->
      e.preventDefault()
      $("#signup-form").ajaxSubmit({success: @handleUpload})

    handleUpload: (response, status, xhr, form) =>
      $(@el).html(@template(_.extend(response, {page : "signup"})))

    closeAlert: (e) ->
      e.preventDefault()
      $(".alert-box")?.fadeOut()
