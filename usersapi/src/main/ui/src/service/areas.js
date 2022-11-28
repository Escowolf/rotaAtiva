import API from "./api";

export default class AreasService {
  getAreas() {
    return API.get("/areas");
  }

  postAreas(area) {
    return API.post("/areas", area);
  }

  deleteAreas(id) {
    return API.delete(`/areas/${id}`);
  }
}
