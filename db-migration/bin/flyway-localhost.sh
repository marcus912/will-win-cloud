#!/usr/bin/env bash

DIR="$(cd "$(dirname $(realpath "${BASH_SOURCE[0]}"))" && pwd)"
BASEDIR=$(realpath $DIR/../..)

if [[ "$1" = "" ]]; then
  CMD="migrate"
else
  CMD=$1
  shift
fi

cd $BASEDIR/db-migration
mvn flyway:$CMD -Dflyway.outOfOrder=true -Dflyway.ignorePendingMigrations=true -P local