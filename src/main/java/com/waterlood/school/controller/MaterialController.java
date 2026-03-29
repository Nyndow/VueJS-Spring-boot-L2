@RestController
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping("/list_mat")
	public List<Material> getCustomers() {
		return materialService.getCustomers();
	}
	
	@GetMapping("/get_mat/{num_materiel}")
	public ResponseEntity<Material> getCustomer(@PathVariable int num_materiel) {
		Optional<Material> materialOptional = materialService.getCustomer(num_materiel);

		if (materialOptional.isPresent()) {
			return ResponseEntity.ok(materialOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/add_mat")
	public ResponseEntity<String> addCustomer(@RequestBody Material material) {
		materialService.addCustomer(material);
		return ResponseEntity.ok("Material added");
	}
	
	@PutMapping("/edit_mat/{num_materiel}")
	public ResponseEntity<Material> updateCustomer(
			@PathVariable int num_materiel,
			@RequestBody Material material) {

		Material updatedMaterial = materialService.updateCustomer(material);
		return ResponseEntity.ok(updatedMaterial);
	}
	
	@DeleteMapping("/delete_mat/{num_materiel}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int num_materiel) {
		materialService.deleteCustomer(num_materiel);
		return ResponseEntity.ok("Material deleted");
	}
}