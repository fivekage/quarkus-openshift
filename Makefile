build_image:
	./mvnw package -DskipTests
	docker build -f src/main/docker/Dockerfile.jvm -t docker.io/elkpuchon/quarkus-hello-world . --platform=linux/amd64
	docker push docker.io/elkpuchon/quarkus-hello-world


deploy_on_oc:
	oc apply -f src/main/kubernetes/deployment.yaml
	oc apply -f src/main/kubernetes/service.yaml
	oc apply -f src/main/kubernetes/routes.yaml

destroy_oc:
	oc delete -f src/main/kubernetes/routes.yaml
	oc delete -f src/main/kubernetes/service.yaml
	oc delete -f src/main/kubernetes/deployment.yaml

update_deployment_image:
	oc rollout restart deployment/open-shift-app-deployment