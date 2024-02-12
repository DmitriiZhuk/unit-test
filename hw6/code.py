# установка необходимых библиотек
# pip install pytest pytest-cov pylint


import pytest
from list_comparator import ListComparator

class ListComparator:
    def __init__(self, list1, list2):
        self.list1 = list1
        self.list2 = list2

    def calculate_average(self, lst):
        if not lst:
            return 0
        return sum(lst) / len(lst)

    def compare_lists(self):
        avg_list1 = self.calculate_average(self.list1)
        avg_list2 = self.calculate_average(self.list2)

        if avg_list1 > avg_list2:
            return "Первый список имеет большее среднее значение"
        elif avg_list1 < avg_list2:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"

@pytest.fixture
def list_comparator():
    list1 = [1, 2, 3, 4, 5]
    list2 = [2, 3, 4, 5, 6]
    return ListComparator(list1, list2)

def test_calculate_average_empty_list():
    lc = ListComparator([], [])
    assert lc.calculate_average([]) == 0

def test_calculate_average_normal_case():
    lc = ListComparator([], [])
    assert lc.calculate_average([1, 2, 3, 4, 5]) == 3

def test_compare_lists(list_comparator):
    assert list_comparator.compare_lists() == "Второй список имеет большее среднее значение"


# test_calculate_average_empty_list: проверяет, что функция calculate_average правильно обрабатывает пустой список.
# test_calculate_average_normal_case: проверяет расчет среднего значения для непустого списка.
# test_compare_lists: проверяет корректность сравнения средних значений двух списков
    
# скрипт для запуска тестов и генерации отчетов:
# pytest --cov-report term-missing --cov=list_comparator
    
#  проверка качества кода с помощью pylint
# pylint list_comparator.py
    


# Тесты, которые были написаны для программы, покрывают основные сценарии использования и проверяют основные функциональности программы:

#     Тестирование расчета среднего значения:
#         test_calculate_average_empty_list: Этот тест проверяет, что функция calculate_average правильно обрабатывает случай пустого списка. Это важно, чтобы убедиться, что программа корректно обрабатывает крайние случаи.
#         test_calculate_average_normal_case: Этот тест проверяет правильность расчета среднего значения для непустого списка. Это важно для убеждения в корректности базовой функциональности.

#     Тестирование сравнения средних значений списков:
#         test_compare_lists: Этот тест проверяет, что программа корректно сравнивает средние значения двух списков и возвращает правильное сообщение о сравнении. Это важная часть функциональности программы, которую необходимо протестировать.

# Почему были выбраны именно эти сценарии:

#     Пустой список: Обработка пустых списков важна для программы, чтобы избежать ошибок или непредвиденного поведения.
#     Нормальный случай: Проверка нормального случая помогает убедиться, что программа работает правильно в типичных условиях.
#     Сравнение списков: Это ключевая часть программы, которую необходимо протестировать, чтобы убедиться, что сравнение средних значений работает правильно.

# Эти тесты позволяют убедиться в корректности работы программы в основных сценариях использования.