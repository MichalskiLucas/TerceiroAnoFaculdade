package br.com.unipar.Hospital.DTO;

import br.com.unipar.Hospital.Model.Consulta;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsultaDto {

    private Long id ;
    private String dataHora;
    private Long id_medico;
    private Long id_paciente;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static ConsultaDto getInstance(Consulta consulta){
        ConsultaDto dto = new ConsultaDto();
        dto.setId(consulta.getId());
        dto.setId_medico(consulta.getMedico().getId());
        dto.setId_paciente(consulta.getPaciente().getId());

        dto.setDataHora(sdf.format(consulta.getDataHora()));

        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Long getId_medico() {
        return id_medico;
    }

    public void setId_medico(Long id_medico) {
        this.id_medico = id_medico;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

}
