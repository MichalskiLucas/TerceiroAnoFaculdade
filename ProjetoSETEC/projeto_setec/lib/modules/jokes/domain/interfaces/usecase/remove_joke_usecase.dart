import 'package:projeto_setec/modules/jokes/core/typedef/typedef.dart';

abstract class RemoveJokeUsecase {
  Future<RemoveJokeResult> call({required String uid});
}
