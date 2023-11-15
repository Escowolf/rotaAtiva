import API from "./api";

export default class VagaService {
  getVaga() {
    return API.get("/zona/auth/user/vagas");
  }

  postVaga(vaga) {
    return API.post("/zona/auth/user/save", vaga);
  }

  deleteVaga(id) {
    return API.delete(`/vaga/?id=${id}`);
  }
}
