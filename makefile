DOCKER = docker exec -it backend-mongodb
# To connect with databse: mongo -u root -p root --authenticationDatabase admin
# Show databases: show dbs
# Show collections: show collections
mongoshell:
  $(DOCKER) bash mongo -u root -p root --authenticationDatabase admin

run:
  docker-compose up

build:
  docker-compose build

