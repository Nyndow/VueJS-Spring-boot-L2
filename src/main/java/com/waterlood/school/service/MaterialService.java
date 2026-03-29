@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;

	public List<Material> getCustomers() {
		return (List<Material>) materialRepository.findAll();
	}
	
	public Optional<Material> getCustomer(int num_materiel) {
		return materialRepository.findById(num_materiel);
	}
	
	public Material addCustomer(Material material) {
		return materialRepository.save(material);
	}
	
	public Material updateCustomer(Material material) {
		int materialId = material.getNum_materiel();

		return materialRepository.findById(materialId)
				.map(existing -> {
					existing.setName(material.getName());
					existing.setQuantity(material.getQuantity());

					return materialRepository.save(existing);
				})
				.orElseThrow(() -> new RuntimeException("Material not found with id: " + materialId));
	}

	public void deleteCustomer(int getNum_materiel) {
		materialRepository.deleteById(getNum_materiel);
	}
}