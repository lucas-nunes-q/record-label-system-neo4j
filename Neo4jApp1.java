/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.facom39701.neo4japp1;

/**
 *
 * @author Lucas Nunes Queiroz - 12011GIN005
 * Projeto app NoSQL Neo4j
 */

import java.util.Scanner;
import org.neo4j.driver.Record;

public class Neo4jApp1 {
    public static void main (String[] args) {
        try (Graph graph = new Graph ("bolt://0.0.0.0:7687",
                                    "neo4j", "12345678")) {

            /*graph.addNode("Musico", "Joao");
            graph.addNode("Musico", "Luiz");
            graph.addNode("Musico", "Maria");
            graph.addNode("Musico", "Raimundo");
            graph.addNode("Musica", "O dia em que eu sai de casa");
            graph.addNode("Musica", "Era uma vez");
            graph.addNode("Musica", "Xica da Silva");
            graph.addNode("Musica", "O dia em que a terra parou");
            graph.addNode("Musica", "O homem mau");
            graph.addRelationship("gravou",
                                "Joao", "O dia em que eu sai de casa");
            graph.addRelationship("gravou",
                                "Luiz", "Era uma vez");
            graph.addRelationship("gravou",
                                "Maria", "Xica da Silva");
            graph.addRelationship("gravou",
                                "Raimundo", "O dia em que a terra parou");
            graph.addRelationship("gravou",
                                "Raimundo", "O homem mau");
            
            System.out.println("Musicos: ");
            for (Record record : graph.listNodes("Musico")) {
                System.out.println (record.get(0).asString());
            }
            System.out.println("Musicas: ");
            for (Record record : graph.listNodes("Musica")) {
                System.out.println(record.get(0).asString());
            }
            System.out.println("Gravou: ");
            for (Record record : graph.listRelatioships("gravou")) {
                System.out.println(record.get(0).asString() + "->" +
                                        record.get(1).asString());
            }*/
            Scanner sc = new Scanner(System.in);
            int select = -1;
            
            loopfora:
                do{
                    System.out.println("");
                    System.out.println("MasucMusic");
                    System.out.println("");
                    System.out.println("(1) Cadastrar musico");
                    System.out.println("(2) Cadastrar musica");
                    System.out.println("(3) Adicionar relacao GRAVOU");
                    System.out.println("(4) Adicionar relacao COMPOS");
                    System.out.println("(5) Listar musicas gravadas por musico");
                    System.out.println("(6) Listar musicas compostas por musico");
                    System.out.println("(7) Listar musicos que compartilham de um mesmo compositor");
                    System.out.println("(0) Sair da aplicacao");
                    System.out.println("");
                    System.out.println("Digite uma das opcoes acima: ");
                    
                    select = Integer.parseInt(sc.nextLine());
            
                    switch (select) {
                        
                        case 0:
                            break;
                        
                        case 1:
                            System.out.println("");
                            System.out.println("Digite o nome do musico: ");
                            String musico = sc.nextLine();
                            graph.addNode("Musico", musico);
                            System.out.println("");
                            System.out.println("Musico cadastrado!");
                            break;
                            
                        case 2:
                            System.out.println("");
                            System.out.println("Digite o nome da musica: ");
                            String musica = sc.nextLine();
                            graph.addNode("Musica", musica);
                            System.out.println("");
                            System.out.println("Musica cadastrada!");
                            break;
                            
                        case 3:
                            System.out.println("Musicos disponiveis: ");
                            System.out.println("");
                            for (Record record : graph.listNodes("Musico")) {
                                System.out.println (record.get(0).asString());
                            }
                            System.out.println("");
                            System.out.println("Digite o nome do musico: ");
                            String musico1 = sc.nextLine();
                            System.out.println("");
                            System.out.println("Musicas disponiveis: ");
                            System.out.println("");
                            for (Record record : graph.listNodes("Musica")) {
                                System.out.println(record.get(0).asString());
                            }
                            System.out.println("");
                            System.out.println("Digite o nome da musica: ");
                            String musica1 = sc.nextLine();
                            System.out.println("");
                            graph.addRelationship("Gravou",
                                                musico1, musica1);
                            System.out.println("Relacao GRAVOU adicionada!");
                            break;
                            
                        case 4:
                            System.out.println("Musicos disponiveis:");
                            System.out.println("");
                            for (Record record : graph.listNodes("Musico")) {
                                System.out.println (record.get(0).asString());
                            }
                            System.out.println("");
                            System.out.println("Digite o nome do musico: ");
                            String musico2 = sc.nextLine();
                            System.out.println("");
                            System.out.println("Musicas disponiveis:");
                            System.out.println("");
                            for (Record record : graph.listNodes("Musica")) {
                                System.out.println(record.get(0).asString());
                            }
                            System.out.println("");
                            System.out.println("Digite o nome da musica: ");
                            String musica2 = sc.nextLine();
                            System.out.println("");
                            graph.addRelationship("Compos",
                                                musico2, musica2);
                            System.out.println("Relacao COMPOS adicionada!");
                            break;
                            
                        case 5:
                            System.out.println("Musicos disponiveis:");
                            System.out.println("");
                            for (Record record : graph.listNodes("Musico")) {
                                System.out.println (record.get(0).asString());
                            }
                            System.out.println("");
                            System.out.println("Digite o nome do musico: ");
                            String musico3 = sc.nextLine();
                            System.out.println("");
                            System.out.println("Musicas gravadas:");
                            System.out.println("");
                            for (Record record : graph.listRelatioships("Gravou")) {
                                /*System.out.println(record.get(0).asString() + "->" +
                                                        record.get(1).asString());*/
                                if (record.get(0).asString().equals(musico3)){
                                    System.out.println(record.get(1).asString());
                                }
                                //System.out.println(record.get(0).asString().equals(musico3) + "->" + record.get(1).asString());
                            }
                            break;
                            
                        case 6:
                            System.out.println("Musicos disponiveis:");
                            System.out.println("");
                            for (Record record : graph.listNodes("Musico")) {
                                System.out.println (record.get(0).asString());
                            }
                            System.out.println("");
                            System.out.println("Digite o nome do musico: ");
                            String musico4 = sc.nextLine();
                            System.out.println("");
                            System.out.println("Musicas compostas:");
                            System.out.println("");
                            for (Record record : graph.listRelatioships("Compos")) {
                                if (record.get(0).asString().equals(musico4)){
                                    System.out.println(record.get(1).asString());
                                }
                            }
                            break;
                            
                        case 7:
                            System.out.println("Musicos disponiveis:");
                            System.out.println("");
                            for (Record record : graph.listNodes("Musico")) {
                                System.out.println (record.get(0).asString());
                            }
                            System.out.println("");
                            System.out.println("Digite o nome do musico: ");
                            String musico5 = sc.nextLine();
                            System.out.println("");
                            System.out.println("Outros musicos:");
                            System.out.println("");
                            for (Record record : graph.listRelatioships("Gravou")) {
                                if (record.get(0).asString().equals(musico5)) {
                                    String musica3 = record.get(1).asString();
                                    for (Record record1 : graph.listRelatioships("Compos")) {
                                        if (record1.get(1).asString().equals(musica3)) {
                                            String compositor = record1.get(0).asString();
                                            for (Record record2 : graph.listRelatioships("Compos")) {
                                                if (record2.get(0).asString().equals(compositor)) {
                                                   String musica4 = record2.get(1).asString();
                                                   for (Record record3 : graph.listRelatioships("Gravou")) {
                                                       if (record3.get(1).asString().equals(musica4)) {
                                                           String musico6 = record3.get(0).asString();
                                                           if (!musico6.equals(musico5)) {
                                                               System.out.println(musico6);
                                                           }
                                                       }
                                                   }
                                                }
                                            }
                                        }
                                    }
                                }
                            };
                            break;
                        
                        default:
                            System.out.println("");
                            System.out.println("Opcao invalida! Tente novamente!");
                            break;
                    }
                } while (select != 0);
        }
    }
}
