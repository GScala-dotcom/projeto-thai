package com.fiap.banksecure.app.repository;

import com.fiap.banksecure.app.config.ConnectionFactory;
import com.fiap.banksecure.app.domain.model.Seguro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeguroDAO {

    public Seguro salvar(Seguro seguro) throws Exception {

        String sql = "INSERT INTO seguro (titulo, cobertura_minima, valor_premio_base) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, seguro.getTitulo());
            stmt.setString(2, seguro.getCoberturaMinima());
            stmt.setBigDecimal(3, seguro.getValorPremioBase());

            stmt.executeUpdate();

            // pega o ID gerado pelo banco
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                seguro.setId(rs.getLong(1));
            }
        }

        return seguro;
    }


    public Seguro buscarPorId(Long id) throws Exception {
        String sql = "SELECT * FROM seguro WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Seguro s = new Seguro();
                s.setId(rs.getLong("id"));
                s.setTitulo(rs.getString("titulo"));
                s.setCoberturaMinima(rs.getString("cobertura_minima"));
                s.setValorPremioBase(rs.getBigDecimal("valor_premio_base"));
                return s;
            }

            return null;
        }
    }

    public void atualizar(Seguro seguro) throws Exception {
        String sql = "UPDATE seguro SET titulo = ?, cobertura_minima = ?, valor_premio_base = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, seguro.getTitulo());
            stmt.setString(2, seguro.getCoberturaMinima());
            stmt.setBigDecimal(3, seguro.getValorPremioBase());
            stmt.setLong(4, seguro.getId());

            stmt.executeUpdate();
        }
    }

    public void excluir(Long id) throws Exception {
        String sql = "DELETE FROM seguro WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

}