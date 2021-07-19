prepare-base-image:
	docker build -f ./docker/prepare.dockerfile -t mvn .

prepare-project-image:
	docker build -f ./docker/launch.dockerfile -t g48 .

launch-tests:
	@[ "${profile}" ] || ( echo "Profile is not set! Usage of command is 'make launch-tests profile=Chrome'"; exit 1 )
	docker run -it -v ${PWD}/allure/allure-results:/app/G48Automation/target/allure-results g48 mvn test -Dusername=BKuso -Dpassword=Ovrush20 -P$(profile)

prepare-all:
	prepare-base-image
	prepare-project-image