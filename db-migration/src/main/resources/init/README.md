# Initialize Apple token Database

1. Run `1-root-user-create-database.sql` with the root user to create the **willwin** user and database.
2. In db-migration-scripts, run `./bin/flyway-localhost.sh baseline` to create the baseline version of Flyway
3. Run flyway with `./bin/flyway-localhost.sh`
