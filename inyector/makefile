IMAGE_NAME=inyector-jdbc:latest
CONTAINER_NAME=logstash-mysql

default: run

build:
	docker build -t $(IMAGE_NAME) ./container/jdbc2redis-injector

run:
	docker run -d -v $(config_dir):/configuration --name $(CONTAINER_NAME) $(IMAGE_NAME) -f /configuration/jdbc2redis.conf

logs:
	docker logs -f $(CONTAINER_NAME)

run-clean:
	docker rm -vf $(CONTAINER_NAME)
	rm dump.rdb
	
run-it:
	docker run -it -v $(config_dir):/configuration --name $(CONTAINER_NAME)-it $(IMAGE_NAME) /bin/bash

run-it-clean:
	docker rm -vf $(CONTAINER_NAME)-it
	rm dump.rdb
