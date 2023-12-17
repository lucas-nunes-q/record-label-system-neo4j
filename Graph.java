/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.facom39701.neo4japp1;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

/**
 *
 * @author docker
 */
public class Graph implements AutoCloseable {

    private final Driver driver;

    public Graph(String uri, String user, String password) {
        this.driver = GraphDatabase.driver(
                uri,
                AuthTokens.basic(user, password)
        );
    }

    public void addNode(final String type, final String name) {
        try (Session session = driver.session()) {
            String query = " MERGE (:" + type + " { name : '" + name + "' })";
            session.run(query);
        }
    }

    public void addRelationship(final String type,
            final String name1,
            final String name2) {
        try (Session session = driver.session()) {
            String query = " MATCH (n1 { name : '" + name1 + "' }) "
                    + " MATCH (n2 { name : '" + name2 + "' }) "
                    + " MERGE (n1) -[:" + type + "]-> (n2)";
            session.run(query);
        }
    }

    public List<Record> listNodes(final String type) {
        List<Record> records = new ArrayList<Record>();
        try (Session session = driver.session()) {
            String query = " MATCH (n:" + type + ") "
                    + " RETURN n. name ";
            Result result = session.run(query);
            records = result.list();
        }
        return records;
    }

    public List< Record> listRelatioships(final String type) {
        List< Record> records = new ArrayList< Record>();
        try (Session session = driver.session()) {
            String query = " MATCH (n1) -[:" + type + "]- (n2) "
                    + " RETURN n1.name , n2. name ";
            Result result = session.run(query);
            records = result.list();
        }
        return records;
    }

    @Override
    public void close() throws RuntimeException {
        driver.close();
    }
}
