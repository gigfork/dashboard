define ["jquery", "backbone", "app/views/login", "app/views/home", "app/views/graph"], ($, Backbone, LoginView, HomeView, GraphView) ->
 
  class AppRouter extends Backbone.Router
    
    routes:
      ""      : "index"
      "login" : "home"
      "graph" : "graph"

    index: ->
      new LoginView()

    home: ->
      new HomeView()

    graph: ->
      new GraphView()