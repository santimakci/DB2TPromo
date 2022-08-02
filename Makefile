DOCKER = docker exec -it db-mongo
# To connect with databse: mongo -u root -p root --authenticationDatabase admin
# Show databases: show dbs
# Show collections: show collections
#mongodb://127.0.0.1:27017/?authSource=admin&compressors=disabled&gssapiServiceName=mongodb

mongoshell:
	$(DOCKER) bash mongo -u root -p root --authenticationDatabase admin
run:
	docker-compose up
build:
	docker-compose build