import 'package:projeto_setec/modules/jokes/core/typedef/typedef.dart';
import 'package:projeto_setec/modules/jokes/domain/interfaces/repository/joke_repository.dart';
import 'package:projeto_setec/modules/jokes/domain/interfaces/usecase/read_jokes_usecase.dart';

class GetJokes implements ReadJokesUsecase {
  final JokeRepository _repository;

  GetJokes(this._repository);
  @override
  Future<ReadJokesResult> call() async {
    return await _repository.readJokes();
  }
}