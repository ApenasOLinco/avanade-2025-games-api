package com.apenasolinco.games_api.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_genre")
public class Genre extends GameAttribute {

}
