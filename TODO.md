# TODO: Fix Maven POM Error (COMPLETED)

## Steps:
- [x] Review project structure and identify issue (POM.xml missing version for security-test dep)
- [x] Analyze POM and tests - confirm unused dependency
- [x] Get user approval on plan (remove unused dep)
- [x] Edit pom.xml to remove spring-boot-starter-security-test
- [x] Test with `mvn clean compile` (successful via .mvnw.cmd)
- [x] Run tests `mvn test` (successful via .mvnw.cmd)
- [ ] Start app with `./mvnw.cmd spring-boot:run`
- [ ] Verify GitHub Actions CI passes on push (push changes to trigger)

## Notes
- Project is Spring Boot 3.3.4 with JWT security, pharmacies/ventes/forecast.
- No security-specific tests yet.
- Frontend in separate dir.
- VSCode Maven may show cached errors - reload/reimport project or ignore.
- Use `./mvnw.cmd` (Windows) instead of `mvn`.
