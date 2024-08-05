#!/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=RealEstateDB
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema2.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data2.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
