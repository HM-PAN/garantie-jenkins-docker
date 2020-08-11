package com.excellentzia.dto;

import com.excellentzia.entities.PGarantie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PGarantieMapper {


    public PGarantieDto entityToDto(PGarantie R) { PGarantieDto Rg = new PGarantieDto();
        Rg.setIdG(R.getIdG());return Rg; }

    public PGarantie DtoToEntity (PGarantieDto R) { PGarantie Rg = new PGarantie();
        Rg.setIdG(R.getIdG()); return Rg; }

    public List<PGarantieDto> entityToDtoList(List<PGarantie> R) { return
            R.stream().map((x)->entityToDto(x)).collect(Collectors.toList()); }

    public List<PGarantie> DtoToEntityList(List<PGarantieDto> R) { return
            R.stream().map((x)->DtoToEntity(x)).collect(Collectors.toList()); }


}
