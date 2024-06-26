package kz.diploma.adapter.service.impl;

import kz.diploma.adapter.model.entity.ClientEntity;
import kz.diploma.adapter.model.entity.dto.AdminDTO;
import kz.diploma.adapter.model.entity.dto.ClientDTO;
import kz.diploma.adapter.model.entity.dto.ProductDTO;
import kz.diploma.adapter.service.AdapterService;
import kz.diploma.adapter.service.impl.subservices.AdminService;
import kz.diploma.adapter.service.impl.subservices.ClientService;
import kz.diploma.adapter.service.impl.subservices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdapterServiceImpl implements AdapterService {
    private final ProductService productService;
    private final AdminService adminService;
    private final ClientService clientService;

    @Override
    public Integer addClient(ClientDTO clientDTO) {
        return clientService.addClient(clientDTO);
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientService.deleteClient(clientId);
    }

    @Override
    public void updateClient(ClientDTO clientDTO, Integer clientId) {
        clientService.updateClient(clientDTO, clientId);
    }

    @Override
    public ClientEntity getClientByPan(String pan) {
        return clientService.getClientByPan(pan);
    }

    @Override
    public List<ClientEntity> getClientByFio(String surname, String name, String lastname) {
        return clientService.getClientByFio(surname, name, lastname);
    }

    @Override
    public ClientEntity getClientByPhoneNumber(String phoneNumber) {
        return clientService.getClientByPhoneNumber(phoneNumber);
    }

    @Override
    public void addClient2BlackList(Integer clientId) {
        clientService.addClient2BlackList(clientId);
    }

    @Override
    public void blockProduct(Integer productId) {
        productService.blockProduct(productId);
    }

    @Override
    public void addClientProduct(Integer clientId) {
        var client = clientService.getClientById(clientId);
        productService.addClientProduct(client);
    }

    @Override
    public void deleteClientProduct(Integer productId) {
        productService.deleteClientProduct(productId);
    }

    @Override
    public void updateClientProduct(ProductDTO productDTO, Integer productId) {
        productService.updateClientProduct(productDTO, productId);
    }

    @Override
    public Integer addAdmin(AdminDTO adminDTO) {
        return adminService.addAdmin(adminDTO);
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        adminService.deleteAdmin(adminId);
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO, Integer adminId) {
        adminService.updateAdmin(adminDTO, adminId);
    }
}
