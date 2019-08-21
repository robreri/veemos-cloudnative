# GitHub repo set-up
* create repo veemos-cloudnative at github
* git init
* git commit -m "initial commit"
* git remote add origin https://github.com/robreri/veemos-cloudnative.git
* git push origin master

# Git Commands
* git add .
* git commit -m " "
* git push origin master


# VEEMOS client set-up

```
	$ node -v
		v10.16.0
```

```
npx create-react-app veemos-client-react
```

```
Success! Created veemos-client-react at C:\k8s\veemos-cloudnative\veemos-client-                                                                                            react
Inside that directory, you can run several commands:

  npm start
    Starts the development server.

  npm run build
    Bundles the app into static files for production.

  npm test
    Starts the test runner.

  npm run eject
    Removes this tool and copies build dependencies, configuration files
    and scripts into the app directory. If you do this, you can’t go back!

We suggest that you begin by typing:

  cd veemos-client-react
  npm start

Happy hacking!
```

* Browser will open at  http://localhost:3000/

# VEEMOS client Docker commands

* note: make sure to delete node_modules!!!

* run build

```
$ docker build -t robreri/veemos-client-react .
```

* push image to Docker registry
```
$ docker push robreri/veemos-client-react
```

* run image
```
$ docker run -p 8080:80 robreri/veemos-client-react
```



# Docker

* to prune all images forcibly without confirmation

````
docker system prune -af
````

* switch to docker daemon in minikube
```
eval $(minikube docker-env)
```

* switch back to local docker daemon
```
eval $(minikube docker-env -u)
```

# Minikube

* start minikube
```
minikube start
````

* check dashboard at http://127.0.0.1:58809/api/v1/namespaces/kube-system/services/http:kubernetes-dashboard:/proxy/#!/overview?namespace=default

```
minikube dashboard
```

* delete service

```
$ kubectl delete service client-node-port
service "client-node-port" deleted
```

* delete pod

```
$ kubectl delete pod client-pod
pod "client-pod" deleted
```

* stop minikube
```
minikube stop
````