DOCKER = docker exec -it backend-mongodb

# To connect with databse: mongo -u root -p root --authenticationDatabase admin
# Show databases: show dbs
# Show collections: show collections

bash:
  $(DOCKER) bash
