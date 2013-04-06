#!/bin/sh

sass --watch src/main/webapp/scss:src/main/webapp/css &
coffee -o src/main/webapp/javascript -cw src/main/webapp/coffeescript 
