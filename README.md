# GitHub repo set-up
* create repo veemos-cloudnative at github
* git init
* git commit -m "initial commit"
* git remote add origin https://github.com/robreri/veemos-cloudnative.git
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