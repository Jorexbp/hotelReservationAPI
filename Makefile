# cargamos las variables de entorno
ifneq (,$(wildcard .env))
    include .env
    export $(shell sed 's/=.*//' .env)
endif

# a lo que vamos
deafult: build run

# la primera de muchas
build:
	docker build -t $(IMAGE_NAME) .

# corre q te pillo
run:
	docker run --rm -p $(PORT):8080 \
		--env "SPRING_DATASOURCE_URL=$(SPRING_DATASOURCE_URL)" \
		--env "SPRING_DATASOURCE_DRIVER=$(SPRING_DATASOURCE_DRIVER)" \
		--env "SPRING_DATASOURCE_USERNAME=$(SPRING_DATASOURCE_USERNAME)" \
		--env "SPRING_DATASOURCE_PASSWORD=$(SPRING_DATASOURCE_PASSWORD)" \
		--name $(CONTAINER_NAME) $(IMAGE_NAME)

# pa vogilar como los project managers
logs:
	docker logs -f $(CONTAINER_NAME)

# le metemos mano al contenedor uwu
sh:
	docker exec -it $(CONTAINER_NAME) sh

# press de banca
stop:
	docker stop $(CONTAINER_NAME)

# te borra hasta el alma
clean:
	docker rm -f $(CONTAINER_NAME) || true
	docker rmi -f $(IMAGE_NAME) || true
	docker system prune -f

# no se toca
.PHONY: deafult build run logs sh stop clean