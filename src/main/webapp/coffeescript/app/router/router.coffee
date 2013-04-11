define ["jquery", "backbone", "app/views/login", "app/views/home", "app/views/signup", "app/views/graph", "app/models/salesdata", "app/collections/salesdatacollection"], ($, Backbone, LoginView, HomeView, SignupView, GraphView, SalesData, SalesDataCollection) ->
 
  class AppRouter extends Backbone.Router
    
    routes:
      ""       : "index"
      "login"  : "home"
      "graph"  : "graph"
      "signup" : "signup"

    index: ->
      new LoginView()

    home: ->
      new HomeView()

    graph: ->
      salesdata = new SalesData()
      salesdataCollection = new SalesDataCollection()
      new GraphView({model: salesdata, collection: salesdataCollection})

    signup: ->
      new SignupView()
