package com.example.barros.model;

import lombok.NonNull;
import org.hibernate.loader.entity.CascadeEntityJoinWalker;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEvento;

    @NonNull
    private String tipoEvento;
    @NonNull
    private Date fecha;
     @NonNull
    private String horaInicio;
     @NonNull
    private String horaFin;
     @NonNull
    private String tipoComida;
     @NonNull
    private String salon;
     @NonNull
    private Integer numComensales;
     @NonNull
    private Integer numContrato;
     @NonNull
    private String menu;
     @NonNull
    private String menuInfantil;
     @NonNull
    private String menusEspeciales;
     @NonNull
    private String planos;
    private String tipoDj;
    private String musicaSalón;
    private String musicaAperitivo;
    private String musicaBaile;
    private String barraLibre;
    private String flores;
    private String ceremonia;
    private String autobuses;
    private Boolean bonoAutobus;
    private Boolean bonoHotel;
    private String vinos;
    private String cava;
    private String rincones;
    private String decoracion;
    private String notas;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "cliente_evento",
            joinColumns = @JoinColumn(name = "idCliente"),
            inverseJoinColumns = @JoinColumn(name = "idEvento"))
    private List<Cliente> clientes;

    public Evento() {

    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Evento(Long   idEvento, @NonNull String tipoEvento, @NonNull Date fecha, @NonNull String horaInicio, @NonNull String horaFin, @NonNull String tipoComida, @NonNull String salon, @NonNull Integer numComensales, @NonNull Integer numContrato, @NonNull String menu, @NonNull String menuInfantil, @NonNull String menusEspeciales, @NonNull String planos, String tipoDj, String musicaSalón, String musicaAperitivo, String musicaBaile, String barraLibre, String flores, String ceremonia, String autobuses, Boolean bonoAutobus, Boolean bonoHotel, String vinos, String cava, String rincones, String decoracion, String notas, List<Cliente> clientes) {
        this.idEvento = idEvento;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tipoComida = tipoComida;
        this.salon = salon;
        this.numComensales = numComensales;
        this.numContrato = numContrato;
        this.menu = menu;
        this.menuInfantil = menuInfantil;
        this.menusEspeciales = menusEspeciales;
        this.planos = planos;
        this.tipoDj = tipoDj;
        this.musicaSalón = musicaSalón;
        this.musicaAperitivo = musicaAperitivo;
        this.musicaBaile = musicaBaile;
        this.barraLibre = barraLibre;
        this.flores = flores;
        this.ceremonia = ceremonia;
        this.autobuses = autobuses;
        this.bonoAutobus = bonoAutobus;
        this.bonoHotel = bonoHotel;
        this.vinos = vinos;
        this.cava = cava;
        this.rincones = rincones;
        this.decoracion = decoracion;
        this.notas = notas;
        this.clientes = clientes;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public Integer getNumComensales() {
        return numComensales;
    }

    public void setNumComensales(Integer numComensales) {
        this.numComensales = numComensales;
    }

    public Integer getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(Integer numContrato) {
        this.numContrato = numContrato;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getMenuInfantil() {
        return menuInfantil;
    }

    public void setMenuInfantil(String menuInfantil) {
        this.menuInfantil = menuInfantil;
    }

    public String getMenusEspeciales() {
        return menusEspeciales;
    }

    public void setMenusEspeciales(String menusEspeciales) {
        this.menusEspeciales = menusEspeciales;
    }

    public String getPlanos() {
        return planos;
    }

    public void setPlanos(String planos) {
        this.planos = planos;
    }

    public String getTipoDj() {
        return tipoDj;
    }

    public void setTipoDj(String tipoDj) {
        this.tipoDj = tipoDj;
    }

    public String getMusicaSalón() {
        return musicaSalón;
    }

    public void setMusicaSalón(String musicaSalón) {
        this.musicaSalón = musicaSalón;
    }

    public String getMusicaAperitivo() {
        return musicaAperitivo;
    }

    public void setMusicaAperitivo(String musicaAperitivo) {
        this.musicaAperitivo = musicaAperitivo;
    }

    public String getMusicaBaile() {
        return musicaBaile;
    }

    public void setMusicaBaile(String musicaBaile) {
        this.musicaBaile = musicaBaile;
    }

    public String getBarraLibre() {
        return barraLibre;
    }

    public void setBarraLibre(String barraLibre) {
        this.barraLibre = barraLibre;
    }

    public String getFlores() {
        return flores;
    }

    public void setFlores(String flores) {
        this.flores = flores;
    }

    public String getCeremonia() {
        return ceremonia;
    }

    public void setCeremonia(String ceremonia) {
        this.ceremonia = ceremonia;
    }

    public String getAutobuses() {
        return autobuses;
    }

    public void setAutobuses(String autobuses) {
        this.autobuses = autobuses;
    }

    public Boolean getBonoAutobus() {
        return bonoAutobus;
    }

    public void setBonoAutobus(Boolean bonoAutobus) {
        this.bonoAutobus = bonoAutobus;
    }

    public Boolean getBonoHotel() {
        return bonoHotel;
    }

    public void setBonoHotel(Boolean bonoHotel) {
        this.bonoHotel = bonoHotel;
    }

    public String getVinos() {
        return vinos;
    }

    public void setVinos(String vinos) {
        this.vinos = vinos;
    }

    public String getCava() {
        return cava;
    }

    public void setCava(String cava) {
        this.cava = cava;
    }

    public String getRincones() {
        return rincones;
    }

    public void setRincones(String rincones) {
        this.rincones = rincones;
    }

    public String getDecoracion() {
        return decoracion;
    }

    public void setDecoracion(String decoracion) {
        this.decoracion = decoracion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}