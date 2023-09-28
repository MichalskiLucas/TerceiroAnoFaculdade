import 'package:projeto_setec/modules/jokes/core/typedef/typedef.dart';
import 'package:projeto_setec/modules/jokes/domain/interfaces/repository/joke_repository.dart';
import 'package:projeto_setec/modules/jokes/domain/interfaces/usecase/remove_joke_usecase.dart';

class RemoveJoke implements RemoveJokeUsecase {
  final JokeRepository _repository;

  RemoveJoke(this._repository);

  @override
  Future<RemoveJokeResult> call({required String uid}) async {
    return await _repository.removeJoke(uid: uid);
  }
}