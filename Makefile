
test:
	mvn test -q

package:
	mvn package -q

travis:
	@mvn clean verify -q
