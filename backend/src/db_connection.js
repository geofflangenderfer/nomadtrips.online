#!/usr/bin/env node
const { Sequelize } = require('sequelize');

// Option 1: Passing a connection URI
const connectionString = 'postgres://postgres:postgres@localhost:5432/nomadtrips_online' // 'postgres://user:pass@example.com:5432/dbname'
const sequelize = new Sequelize(connectionString) // Example for postgres

async function test_db() {
  try {
    await sequelize.authenticate();
    console.log('Connection has been established successfully.');
  } catch (error) {
    console.error('Unable to connect to the database:', error);
  }

}
test_db()
